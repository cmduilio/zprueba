package com.samit.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCHEDULE_ID")
    private Long id;

	@Column(name = "SCHEDULE_DATE")
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
