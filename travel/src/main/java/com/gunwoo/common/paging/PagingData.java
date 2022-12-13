package com.gunwoo.common.paging;

public class PagingData
{
    private Long totalRecordSize; // 전체 레코드 수
    private int totalPageGroupSize; // 전체 페이지 그룹 수
    private int totalPageSize;  // 전체 페이지 수
    private int pageSize; // 페이지 당 보여줄 글 갯수.
    private int pageGroupSize; // 페이지 그룹안의 페이지 갯수.
    private int currentPageGroup; // 현재 페이지 그룹 번호
    private int currentPage; // 현재 페이지
    private int currentPageRowCount;
    private int startPage; // 시작 페이지 번호
    private int endPage; // 페이지의 끝 번호
    private int startRow; // 페이지의 시작글 번호.
    private int endRow; // 페이지의 마지막 글번호.
    private Object object;

    public PagingData()
    {
        pageSize = 10;
        pageGroupSize = 5;
    }

    public PagingData(Long totalRecordSize, int pageSize, int pageGroupSize, int totalPageGroupSize, int currentPage, int startPage, int endPage, int startRow, int endRow)
    {
        super();
        this.totalRecordSize = totalRecordSize;
        this.pageSize = pageSize;
        this.pageGroupSize = pageGroupSize;
        this.totalPageGroupSize = totalPageGroupSize;
        this.currentPage = currentPage;
        this.startPage = startPage;
        this.endPage = endPage;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    public PagingData(Long totalRecordSize, int currentPage, int pageSize, int pageGroupSize)
    {
        this.totalRecordSize = totalRecordSize;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageGroupSize = pageGroupSize;
    }

    public Long getTotalRecordSize()
    {
        return totalRecordSize;
    }

    public void setTotalRecordSize(Long totalRecordSize)
    {
        this.totalRecordSize = totalRecordSize;
    }

    public int getTotalPageGroupSize()
    {
        return totalPageGroupSize;
    }

    public void setTotalPageGroupSize(int totalPageGroupSize)
    {
        this.totalPageGroupSize = totalPageGroupSize;
    }

    public int getTotalPageSize()
    {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize)
    {
        this.totalPageSize = totalPageSize;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getPageGroupSize()
    {
        return pageGroupSize;
    }

    public void setPageGroupSize(int pageGroupSize)
    {
        this.pageGroupSize = pageGroupSize;
    }

    public int getCurrentPageGroup()
    {
        return currentPageGroup;
    }

    public void setCurrentPageGroup(int currentPageGroup)
    {
        this.currentPageGroup = currentPageGroup;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getCurrentPageRowCount()
    {
        return currentPageRowCount;
    }

    public void setCurrentPageRowCount(int currentPageRowCount)
    {
        this.currentPageRowCount = currentPageRowCount;
    }

    public int getStartPage()
    {
        return startPage;
    }

    public void setStartPage(int startPage)
    {
        this.startPage = startPage;
    }

    public int getEndPage()
    {
        return endPage;
    }

    public void setEndPage(int endPage)
    {
        this.endPage = endPage;
    }

    public int getStartRow()
    {
        return startRow;
    }

    public void setStartRow(int startRow)
    {
        this.startRow = startRow;
    }

    public int getEndRow()
    {
        return endRow;
    }

    public void setEndRow(int endRow)
    {
        this.endRow = endRow;
    }

    public Object getObject()
    {
        return object;
    }

    public void setObject(Object object)
    {
        this.object = object;
    }

    @Override
    public String toString()
    {
        return "Paging [totalRecordSize=" + totalRecordSize + ", totalPageGroupSize=" + totalPageGroupSize + ", totalPageSize=" + totalPageSize + ", pageSize=" + pageSize + ", pageGroupSize=" + pageGroupSize + ", currentPageGroup=" + currentPageGroup + ", currentPage=" + currentPage
                + ", startPage=" + startPage + ", endPage=" + endPage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
    }
}