package br.com.api.incidents.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "INCIDENTS")
public class Incidents implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Incidents(long idincident, String name, String description, Date createdAt, Date updateAt, Date closeAt) {
		
		this.idincident = idincident;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.closeAt = closeAt;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
	private long idincident;
    
    @Column(name = "NAME", length = 50, nullable = false)
	private String name;
    
    @Column(name = "DESCRIPTION")
	private String description;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATEDAT")
	private Date createdAt;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATEAT")
	private Date updateAt;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CLOSEAT")
	private Date closeAt;
	
	public Incidents() {
		super();
	}

	public long getIdincident() {
		return idincident;
	}

	public void setIdincident(long idincident) {
		this.idincident = idincident;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Date getCloseAt() {
		return closeAt;
	}

	public void setCloseAt(Date closeAt) {
		this.closeAt = closeAt;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidents other = (Incidents) obj;
		return idincident == other.idincident;
	}

}
