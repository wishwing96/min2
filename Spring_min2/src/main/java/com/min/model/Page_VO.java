package com.min.model;

public class Page_VO {

	//페이징의 시작번호
	private int startPage;
	//페이징의 끝번호
	private int endPage;
	//페이징의 이전
	private boolean prev;
	//페이징의 다음
	private boolean next;
	
	private int total;//전체가 몇건인지를 알아야 '페이징의 이전', '페이징의 다음'을 만들지 판단
	private Recode rec;
	
	public Page_VO(Recode rec , int total) {// 매개변수 2개인 생성자
		this.rec=rec;
		this.total=total;
		
		// 페이징의 끝번호를 알 수 있게 계산
		this.endPage=(int)(Math.ceil(rec.getpagenum()/10.0))*10;
		this.startPage=this.endPage-9;
		int realEnd=(int)(Math.ceil((total*1.0)/rec.getamount()));
		
		if(realEnd < this.endPage) {
			this.endPage=realEnd;
		}
		
		this.prev=this.startPage>1;
		
		this.next=this.endPage < realEnd;
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Recode  getRec() {
		return rec;
	}

	public void setRec(Recode rec) {
		this.rec = rec;
	}
	
	
	
}

