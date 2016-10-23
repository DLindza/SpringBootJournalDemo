package lindsay.devon.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity; /// mark this as a JPA entry
import javax.persistence.GeneratedValue; /// mark this as a JPA entry
import javax.persistence.GenerationType;
import javax.persistence.Id; /// mark this as a JPA entry
import javax.persistence.Transient;
/**
 * Created by devon on 10/20/16.
 */
@Entity/// mark this as a JPA entry/record
public class Journal {
        @Id/// mark this as a JPA entry
        @GeneratedValue(strategy = GenerationType.AUTO)/// mark this as a JPA entry
        private Long id;
        private String title;
        private Date created;
        private String summary;

        @Transient /// let's JPA not to persist this property (it's only being used to format the date)
        private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");



        //Second constructor for our use to help populate the database
        public Journal(String title, String summary, String date) throws ParseException {
            this.title = title;
            this. summary = summary;
            this.created = format.parse(date);
        }

        Journal() {} // empty constructor needed for the JPA

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getCreatedAsShort() {
            return format.format(created);
        }

        ///overriding toString method to help print out the records
        public String toString() {
            StringBuilder value = new StringBuilder("Journal Entry(");
            value.append("Id: ");
            value.append(id);
            value.append(",Title: ");
            value.append(title);
            value.append(", Summary: ");
            value.append(summary);
            value.append(", Created: ");
            value.append(getCreatedAsShort());
            value.append(")");
            return value.toString();
        }
 }


