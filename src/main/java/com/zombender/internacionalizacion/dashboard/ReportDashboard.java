package com.zombender.internacionalizacion.dashboard;

import org.openxava.annotations.*;
import org.openxava.jpa.*;

@View(members = "numberOfReports, totalEvents, totalSentStudents, totalReceivedStudents")
public class ReportDashboard {

    @LargeDisplay(icon = "report")
    public String getNumberOfReports() {
        return XPersistence.getManager()
                .createQuery("select count(report_oid) from Report")
                .getSingleResult().toString();
    }

    @LargeDisplay(icon = "event")
    public int getTotalEvents() {
        return ((Number) XPersistence.getManager()
                .createQuery("select sum(events) from Report")
                .getSingleResult()).intValue();
    }

    @LargeDisplay(icon = "student")
    public int getTotalSentStudents() {
        return ((Number) XPersistence.getManager()
                .createQuery("select sum(sentStudents) from Report")
                .getSingleResult()).intValue();
    }

    @LargeDisplay(icon = "student")
    public int getTotalReceivedStudents() {
        return ((Number) XPersistence.getManager()
                .createQuery("select sum(receivedStudents) from Report")
                .getSingleResult()).intValue();
    }
    /*
    @Chart
    public Collection<ReportEvolution> getReportEvolution() {
        String jpql = "select new com.zombender.internacionalizacion.dashboard.ReportEvolution(" +
                      "YEAR(creationDate), MONTH(creationDate), sum(events)) " +
                      "from Report " +
                      "group by YEAR(creationDate), MONTH(creationDate) " +
                      "order by YEAR(creationDate), MONTH(creationDate) asc";
        TypedQuery<ReportEvolution> query = XPersistence.getManager()
                .createQuery(jpql, ReportEvolution.class);
        return query.getResultList();
    }
    */
    /*
    @SimpleList
    @ListProperties("faculty.name, totalReports, totalEvents")
    public Collection<TopFaculty> getTopFaculty() {
        String jpql = "select new com.zombender.internacionalizacion.dashboard.TopFaculty(" +
                      "faculty.name, count(report_oid), sum(events)) " +
                      "from Report " +
                      "group by faculty.name " +
                      "order by sum(events) desc";
        TypedQuery<TopFaculty> query = XPersistence.getManager()
                .createQuery(jpql, TopFaculty.class)
                .setMaxResults(5);
        return query.getResultList();
    }
    */
}