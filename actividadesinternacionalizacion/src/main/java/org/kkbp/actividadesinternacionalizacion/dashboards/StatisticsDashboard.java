package org.kkbp.actividadesinternacionalizacion.dashboards;

import java.util.*;
import java.util.stream.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.jpa.*;

@View(members="Global {" + "totalEvents; "
+ "totalSentStudents, totalReceivedStudents, totalVirtualModeStudents; "
+ "totalSentTeachers, totalReceivedTeachers, totalVirtualModeTeachers; "
+ "eventsPerFaculty" + "}"
+ "FIA {" 
+ "totalEventsFia; "
+ "totalSentStudentsFia, totalReceivedStudentsFia, totalVirtualModeStudentsFia; "
+ "totalSentTeachersFia, totalReceivedTeachersFia, totalVirtualModeTeachersFia" + "}"
+ "FCM {" 
+ "totalEventsFcm; "
+ "totalSentStudentsFcm, totalReceivedStudentsFcm, totalVirtualModeStudentsFcm; "
+ "totalSentTeachersFcm, totalReceivedTeachersFcm, totalVirtualModeTeachersFcm" + "}"
+ "FODO {" 
+ "totalEventsFodo; "
+ "totalSentStudentsFodo, totalReceivedStudentsFodo, totalVirtualModeStudentsFodo; "
+ "totalSentTeachersFodo, totalReceivedTeachersFodo, totalVirtualModeTeachersFodo" + "}"
+ "FCAE {" 
+ "totalEventsFcae; "
+ "totalSentStudentsFcae, totalReceivedStudentsFcae, totalVirtualModeStudentsFcae; "
+ "totalSentTeachersFcae, totalReceivedTeachersFcae, totalVirtualModeTeachersFcae" + "}"
+ "FCJHRI {" 
+ "totalEventsFcjhri; "
+ "totalSentStudentsFcjhri, totalReceivedStudentsFcjhri, totalVirtualModeStudentsFcjhri; "
+ "totalSentTeachersFcjhri, totalReceivedTeachersFcjhri, totalVirtualModeTeachersFcjhri" + "}"
+ "FMDCC {" 
+ "totalEventsFmdcc; "
+ "totalSentStudentsFmdcc, totalReceivedStudentsFmdcc, totalVirtualModeStudentsFmdcc; "
+ "totalSentTeachersFmdcc, totalReceivedTeachersFmdcc, totalVirtualModeTeachersFmdcc" + "}"
+ "COLLEGE {" 
+ "totalEventsUamCol; "
+ "totalSentStudentsUamCol, totalReceivedStudentsUamCol, totalVirtualModeStudentsUamCol; "
+ "totalSentTeachersUamCol, totalReceivedTeachersUamCol, totalVirtualModeTeachersUamCol" + "}") 
public class StatisticsDashboard {
	@LargeDisplay(icon="account-multiple")
	public String getTotalEvents() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudents() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudents() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudents() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachers() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachers() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachers() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}

	@Chart
	public Collection<TotalEventsPerFaculty> getEventsPerFaculty() {
		String jpql = "select new org.kkb.actividadesinternacionalizacion.dashboards.TotalEventsPerFaculty("
				+ "f.name, sum(r.events)"
				+ "from Report r"
				+ "join r.faculty f"
				+ "group by f.name";
		TypedQuery<TotalEventsPerFaculty> query = XPersistence.getManager()
				.createQuery(jpql, TotalEventsPerFaculty.class);
		List<TotalEventsPerFaculty> results = query.getResultList();
		if (results == null || results.isEmpty()) {
			return Collections.emptyList();
		}
		return results.stream().filter(Objects::nonNull).collect(Collectors.toList());
		// return query.getResultList();
	}
	
	// FIA
	@LargeDisplay(icon="account-multiple")
	public String getTotalEventsFia() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FIA'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudentsFia() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FIA'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudentsFia() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FIA'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudentsFia() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FIA'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachersFia() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FIA'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachersFia() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FIA'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachersFia() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FIA'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	// FCM
	@LargeDisplay(icon="account-multiple")
	public String getTotalEventsFcm() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCM'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudentsFcm() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCM'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudentsFcm() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCM'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudentsFcm() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCM'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachersFcm() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCM'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachersFcm() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCM'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachersFcm() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCM'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}

	// FODO
	@LargeDisplay(icon="account-multiple")
	public String getTotalEventsFodo() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FODO'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudentsFodo() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FODO'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudentsFodo() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FODO'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudentsFodo() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FODO'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachersFodo() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FODO'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachersFodo() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FODO'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachersFodo() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FODO'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	// FCAE
	@LargeDisplay(icon="account-multiple")
	public String getTotalEventsFcae() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCAE'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudentsFcae() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCAE'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudentsFcae() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCAE'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudentsFcae() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCAE'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachersFcae() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCAE'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachersFcae() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCAE'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachersFcae() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCAE'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	// FCJHRI
	@LargeDisplay(icon="account-multiple")
	public String getTotalEventsFcjhri() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCJHRI'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudentsFcjhri() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCJHRI'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudentsFcjhri() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCJHRI'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudentsFcjhri() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCJHRI'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachersFcjhri() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCJHRI'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachersFcjhri() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCJHRI'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachersFcjhri() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FCJHRI'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}

	// FMDCC
	@LargeDisplay(icon="account-multiple")
	public String getTotalEventsFmdcc() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FMDCC'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudentsFmdcc() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FMDCC'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudentsFmdcc() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FMDCC'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudentsFmdcc() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FMDCC'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachersFmdcc() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FMDCC'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachersFmdcc() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FMDCC'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachersFmdcc() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'FMDCC'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	// UAMCOLLEGE
	@LargeDisplay(icon="account-multiple")
	public String getTotalEventsUamCol() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(events) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'UAMCOL'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudentsUamCol() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'UAMCOL'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudentsUamCol() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'UAMCOL'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudentsUamCol() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeStudents) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'UAMCOL'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachersUamCol() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(sentTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'UAMCOL'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachersUamCol() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(receivedTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'UAMCOL'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachersUamCol() {
		Object resultado = XPersistence.getManager()
				.createNativeQuery("select sum(virtualModeTeachers) from Report R JOIN FACULTY F ON R.FACULTY_FACULTY_OID = F.FACULTY_OID WHERE F.ABBREVIATION = 'UAMCOL'").getSingleResult();
		return resultado != null ? resultado.toString() : "0";
	}
}
