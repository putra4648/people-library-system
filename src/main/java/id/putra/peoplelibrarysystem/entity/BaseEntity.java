package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;

import java.util.Date;

@MappedSuperclass
@Builder
public class BaseEntity {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "modified_at")
    private Date modifiedAt;

    public BaseEntity() {
    }
}
