package com.revature.models;

public enum Selection {

    Course {
        @Override
        public String toString() {
            return "University Course";
        }
    },

    Seminar {
        @Override
        public String toString () {
            return "Seminar";
        }
    },
    Prep{
        @Override
        public String toString() {
            return "Certification Prep";
        }
    },
    techTraining {
        @Override
        public String toString() {
            return "Technical Training";
        }
    },
    other {
        @Override
        public String toString() {
            return "Other";
        }
    }
    }