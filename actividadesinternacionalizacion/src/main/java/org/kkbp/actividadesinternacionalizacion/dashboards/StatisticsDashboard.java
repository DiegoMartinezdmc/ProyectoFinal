package org.kkbp.actividadesinternacionalizacion.dashboards;

import org.openxava.annotations.*;
import org.openxava.jpa.*;

@View(members="totalEvents;"
+ "totalSentStudents, totalReceivedStudents, totalVirtualModeStudents;"
+ "totalSentTeachers, totalReceivedTeachers, totalVirtualModeTeachers;")
public class StatisticsDashboard {
	@LargeDisplay(icon="account-multiple")
	public String getTotalEvents() {
		return XPersistence.getManager()
				.createQuery("select sum(events) from Report").getSingleResult().toString();
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentStudents() {
		return XPersistence.getManager()
				.createQuery("select sum(sentStudents) from Report").getSingleResult().toString();
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedStudents() {
		return XPersistence.getManager()
				.createQuery("select sum(receivedStudents) from Report").getSingleResult().toString();
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeStudents() {
		return XPersistence.getManager()
				.createQuery("select sum(virtualModeStudents) from Report").getSingleResult().toString();
	}
	
	@LargeDisplay(icon="airplane-takeoff")
	public String getTotalSentTeachers() {
		return XPersistence.getManager()
				.createQuery("select sum(sentTeachers) from Report").getSingleResult().toString();
	}
	
	@LargeDisplay(icon="call-received")
	public String getTotalReceivedTeachers() {
		return XPersistence.getManager()
				.createQuery("select sum(receivedTeachers) from Report").getSingleResult().toString();
	}
	
	@LargeDisplay(icon="laptop")
	public String getTotalVirtualModeTeachers() {
		return XPersistence.getManager()
				.createQuery("select sum(virtualModeTeachers) from Report").getSingleResult().toString();
	}
}
