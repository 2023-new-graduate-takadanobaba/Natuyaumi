package jp.co.sss.natuyasumi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorite")
public class FavoriteEntity {
@Id
private Integer id;

@Column
private String sessionId;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getSessionId() {
	return sessionId;
}

public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
}




}
