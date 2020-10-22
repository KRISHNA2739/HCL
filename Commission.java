public class Commission extends Commondetails {
	int ps,ts,p=1;
	
	public Commission(int ps, int ts) {
		this.ps = ps;
		this.ts = ts;
	}


	public void salaryupd(int upd)
	{
		this.p=upd;
	}
	public void salarycal()
	{
		salary=(ps*ts*p/100);
	}

	
}