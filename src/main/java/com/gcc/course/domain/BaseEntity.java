package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by huangMP on 2017/3/30.
 * decription :
 */
@MappedSuperclass
public class BaseEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "UUID2_GENERATOR")
    public String id;

    /**
     * 是否被删除，1为true，0为false
     */
    @Column(columnDefinition = "INT default 0")
    public int status ;

    /**
     * 删除 (软删除)
     */
    public boolean delete(){
        this.setStatus(1);
        this.setDeletedTime(LocalDateTime.now());
        return isDeleted();
    }

    /**
     * 查看该实体是否被删除
     * @return
     */
    public boolean isDeleted(){
        return this.status == 1 ? true : false ;
    }

    public BaseEntity() {
        this.status = 0 ;
    }

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime deletedTime; //删除时间

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
