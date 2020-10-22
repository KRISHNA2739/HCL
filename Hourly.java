
 class Hourly extends Commondetails {
private int sh=1,noh;
	
 public void salaryupd(int upd)
 {
	this.sh=upd;
 }

public Hourly(int noh) {
	
	this.noh = noh;
  }

	public void salarycal()
	{
		salary=(sh*noh);
	}
	


}