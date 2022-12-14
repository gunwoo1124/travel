package com.server.common.model.vo;

import java.util.Date;

public class MemberTripVO {
    private Long mtIdx;

    private Long mtCtIdx;

    private Long mtMbIdx;

    private Boolean mtState;

    private Date mtCreateDate;

    private String mtName;

    private String mtDescription;

    private Date mtUpdateDate;

    private Date mtDeleteDate;

    private Date mtStartDate;

    private Date mtEndDate;

    public Long getMtIdx() {
        return mtIdx;
    }

    public void setMtIdx(Long mtIdx) {
        this.mtIdx = mtIdx;
    }

    public Long getMtCtIdx() {
        return mtCtIdx;
    }

    public void setMtCtIdx(Long mtCtIdx) {
        this.mtCtIdx = mtCtIdx;
    }

    public Long getMtMbIdx() {
        return mtMbIdx;
    }

    public void setMtMbIdx(Long mtMbIdx) {
        this.mtMbIdx = mtMbIdx;
    }

    public Boolean getMtState() {
        return mtState;
    }

    public void setMtState(Boolean mtState) {
        this.mtState = mtState;
    }

    public Date getMtCreateDate() {
        return mtCreateDate;
    }

    public void setMtCreateDate(Date mtCreateDate) {
        this.mtCreateDate = mtCreateDate;
    }

    public String getMtName() {
        return mtName;
    }

    public void setMtName(String mtName) {
        this.mtName = mtName;
    }

    public String getMtDescription() {
        return mtDescription;
    }

    public void setMtDescription(String mtDescription) {
        this.mtDescription = mtDescription;
    }

    public Date getMtUpdateDate() {
        return mtUpdateDate;
    }

    public void setMtUpdateDate(Date mtUpdateDate) {
        this.mtUpdateDate = mtUpdateDate;
    }

    public Date getMtDeleteDate() {
        return mtDeleteDate;
    }

    public void setMtDeleteDate(Date mtDeleteDate) {
        this.mtDeleteDate = mtDeleteDate;
    }

    public Date getMtStartDate() {
        return mtStartDate;
    }

    public void setMtStartDate(Date mtStartDate) {
        this.mtStartDate = mtStartDate;
    }

    public Date getMtEndDate() {
        return mtEndDate;
    }

    public void setMtEndDate(Date mtEndDate) {
        this.mtEndDate = mtEndDate;
    }
}