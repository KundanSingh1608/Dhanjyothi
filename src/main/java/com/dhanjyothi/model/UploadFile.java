package com.dhanjyothi.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FILES_UPLOAD",schema = "kundan")
public class UploadFile implements Serializable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 3686127810199290608L;
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_ID")
	private int id;
	@Column(name = "FILE_NAME",length=300, nullable=false)
	private String fileName;
	@Column(name = "FILE_TYPE",length=100, nullable=false)
	private String fileType;
	@Column(name = "FILE_CATEGORY")
	private String fileCategory;
    public String getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}

	@Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "FILE_DATA")
	private byte[] data;
	@ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
	
	public UploadFile() {}
	
	public UploadFile(String fileName, String fileType, byte[] data, User user) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//getters and setters...........

    public long getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }
    
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "UploadFile [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", fileCategory="
				+ fileCategory + ", data=" + Arrays.toString(data) + ", user=" + user + "]";
	}
	
}
