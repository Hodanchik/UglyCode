package by.epam.training.travelagency.service.comparator;

import org.apache.log4j.Logger;

import java.util.Comparator;

public class BeanComparator implements Comparator<Object> {
    private static final Logger log = Logger.getLogger(BeanComparator.class);

    private String getter;

    public BeanComparator(String field) {
        this.getter = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    public int compare(Object o1, Object o2) {
        try {
            if (o1 != null && o2 != null) {
                o1 = o1.getClass().getMethod(getter, new Class[0]).invoke(o1, new Object[0]);
                o2 = o2.getClass().getMethod(getter, new Class[0]).invoke(o2, new Object[0]);
            }
        } catch (Exception e) {
            log.error("RuntimeException, can not compare objects");
            throw new RuntimeException("Cannot compare " + o1 + " with " + o2 + " on " + getter, e);
        }
        return (o1 == null) ? -1 : ((o2 == null) ? 1 : ((Comparable<Object>) o1).compareTo(o2));
    }

}