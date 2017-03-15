package kz.fa.firebasewriter.model;

/**
 * Created by abay on 2/13/17.
 */
public class FireRegion {

        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Region{" + "id=" + id + ", name=" + name + '}';
        }


    }

