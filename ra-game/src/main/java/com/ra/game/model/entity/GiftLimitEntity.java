package com.ra.game.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gift_limit", schema = "ra_game", catalog = "")
public class GiftLimitEntity {
    private String id;
    private String giftCode;
    private String limitType;
    private Double limit;
    private Double remaining;
    private String status;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gift_code")
    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }

    @Basic
    @Column(name = "limit_type")
    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    @Basic
    @Column(name = "limit")
    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @Basic
    @Column(name = "remaining")
    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "updated_date")
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GiftLimitEntity that = (GiftLimitEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (giftCode != null ? !giftCode.equals(that.giftCode) : that.giftCode != null) return false;
        if (limitType != null ? !limitType.equals(that.limitType) : that.limitType != null) return false;
        if (limit != null ? !limit.equals(that.limit) : that.limit != null) return false;
        if (remaining != null ? !remaining.equals(that.remaining) : that.remaining != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (giftCode != null ? giftCode.hashCode() : 0);
        result = 31 * result + (limitType != null ? limitType.hashCode() : 0);
        result = 31 * result + (limit != null ? limit.hashCode() : 0);
        result = 31 * result + (remaining != null ? remaining.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}
