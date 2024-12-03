package org.kkbp.proyectointernacionalizacion.modelo;

import org.openxava.actions.ViewBaseAction;

import javax.persistence.*;
import java.util.List;

public class CalculateDashboard extends ViewBaseAction {
    @Override
    public void execute() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(
                "SELECT r.faculty, " +
                        "       FUNCTION('QUARTER', r.creationDate), " +
                        "       r.year, " +
                        "       SUM(r.sentStudents), " +
                        "       SUM(r.receivedStudents), " +
                        "       SUM(r.virtualModeStudents), " +
                        "       SUM(r.sentTeachers), " +
                        "       SUM(r.receivedTeachers), " +
                        "       SUM(r.virtualModeTeachers) " +
                        "FROM Report r " +
                        "GROUP BY r.faculty, FUNCTION('QUARTER', r.creationDate), r.year"
        );

        // Ejecutar la consulta
        List<Object[]> results = query.getResultList();

        // Limpiar la vista actual antes de agregar los nuevos resultados
        getView().clear();

        // Procesar los resultados
        for (Object[] row : results) {
            Faculty faculty = (Faculty) row[0];
            int quarter = (int) row[1]; // Trimestre devuelto por FUNCTION('QUARTER')
            String year = (String) row[2];
            int totalSentStudents = ((Long) row[3]).intValue();
            int totalReceivedStudents = ((Long) row[4]).intValue();
            int totalVirtualModeStudents = ((Long) row[5]).intValue();
            int totalSentTeachers = ((Long) row[6]).intValue();
            int totalReceivedTeachers = ((Long) row[7]).intValue();
            int totalVirtualModeTeachers = ((Long) row[8]).intValue();

            Semester semester = quarterToSemester(quarter);

            // Crear un nuevo objeto ReportDashboard para cada resultado
            Dashboard dashboard = new Dashboard();
            dashboard.setFaculty(faculty);
            dashboard.setSemester(semester);
            dashboard.setYear(year);
            dashboard.setTotalSentStudents(totalSentStudents);
            dashboard.setTotalReceivedStudents(totalReceivedStudents);
            dashboard.setTotalVirtualModeStudents(totalVirtualModeStudents);
            dashboard.setTotalSentTeachers(totalSentTeachers);
            dashboard.setTotalReceivedTeachers(totalReceivedTeachers);
            dashboard.setTotalVirtualModeTeachers(totalVirtualModeTeachers);

            // Pasar los valores a la vista
            addDashboardToView(dashboard);
        }
    }

    /**
     * Convierte un trimestre en un semestre.
     */
    private Semester quarterToSemester(int quarter) {
        if (quarter == 1 || quarter == 2) {
            return Semester.I;
        } else {
            return Semester.II;
        }
    }

    /**
     * Añade un objeto ReportDashboard a la vista actual.
     */
    private void addDashboardToView(Dashboard dashboard) throws Exception {
        getView().setValue("faculty", dashboard.getFaculty());
        getView().setValue("semester", dashboard.getSemester());
        getView().setValue("year", dashboard.getYear());
        getView().setValue("totalSentStudents", dashboard.getTotalSentStudents());
        getView().setValue("totalReceivedStudents", dashboard.getTotalReceivedStudents());
        getView().setValue("totalVirtualModeStudents", dashboard.getTotalVirtualModeStudents());
        getView().setValue("totalSentTeachers", dashboard.getTotalSentTeachers());
        getView().setValue("totalReceivedTeachers", dashboard.getTotalReceivedTeachers());
        getView().setValue("totalVirtualModeTeachers", dashboard.getTotalVirtualModeTeachers());
    }
}
