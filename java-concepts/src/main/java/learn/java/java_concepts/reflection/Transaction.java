package learn.java.java_concepts.reflection;

public class Transaction {
	private String trnCd;
	private String transactionCategory;
	private String transactionType;
	private String reasonCd;
	public String getTrnCd() {
		return trnCd;
	}
	public void setTrnCd(String trnCd) {
		this.trnCd = trnCd;
	}
	public String getTransactionCategory() {
		return transactionCategory;
	}
	public void setTransactionCategory(String transactionCategory) {
		this.transactionCategory = transactionCategory;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getReasonCd() {
		return reasonCd;
	}
	public void setReasonCd(String reasonCd) {
		this.reasonCd = reasonCd;
	}
	
	
}
