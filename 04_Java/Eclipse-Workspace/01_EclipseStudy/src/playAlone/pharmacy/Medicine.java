package playAlone.pharmacy;

public enum Medicine {
	ATIVAN_TAB_05MG("정제", "아티반정 0.5mg", "일동제약", new String[] {"Lorazepam 0.5mg"}, 22, true, true, true),
	ATIVAN_TAB_1MG("정제", "아티반정 1mg", "일동제약", new String[] {"Lorazepam 1mg"}, 41, true, true, true), 
	ATIVAN_INJ_05ML("주사제", "아티반주사 0.5ml", "일동제약", new String[] {"Lorazepam 2mg"}, 782, true, true, true), 
	ATIVAN_INJ_1ML("주사제", "아티반주사 0.5ml", "일동제약", new String[] {"Lorazepam 4mg"}, 804, true, true, true),
	BANAN_DRY_50MG_5ML ("건조시럽", "바난건조시럽 50mg\\/5ml (200ml)", "에이치케이이노엔", new String[] {"Cefpodoxime Proxetil 50mg"}, 104, true, true, false),
	BANAN_TAB ("정제", "바난정", "에이치케이이노엔", new String[] {"Cefpodoxime Proxetil 100mg"}, 553, true, true, false),
	BODYGREEN_CAP ("캡슐", "바디그린 캡슐", "한국넬슨제약", new String[] {"Green Tea Powder 250mg", "Orthosiphon Powder 150mg"}, false, false, false),
	CLONAZEPAM_TAB_05MG ("정제", "클로나제팜정 0.5mg", "환인제약", new String[] {"Clonazepam 0.5mg"}, 30, true, true, true),
	TYLENOL_8H_ER_TAB ("서방정", "타이레놀 8시간 이알 서방정", "한국얀센", new String[] {"속박층 : Acetaminophen 325mg", "서방층 : Acetaminophen 325mg"}, 90, false, true, false),
	HYALUMINI_01PER_05ML ("점안제", "히알루미니 점안액 0.1% (0.5ml)", "한미약품", new String[] {"Sodium Hyaluronate 1mg\\/ml"}, 198, true, true, false),
	HYALUMINI_015PER_05ML ("점안제", "히알루미니 점안액 0.15% (0.5ml)", "한미약품", new String[] {"Sodium Hyaluronate 1.5mg\\/ml"}, 248, true, true, false),
	BOSONG_CRE_10G ("크림", "보송크림 (10g)", "안국약품", new String[] {"Prednisolone Valeroacetate 3mg\\/g"}, 960, true, true, false),
	CENDOM_ODF_10MG ("구강용해필름제", "센돔 구강용해필름 10mg", "종근당", new String[] {"Tadalafil 10mg"}, true, false, false),
	KAIZAL_SYR ("시럽제", "카이잘액", "대우제약", new String[] {"Levocetirizine Hydrochloride 0.5mg\\/ml"}, 40, true, true, false);

	private final String type;
	private final String name;
	private final String madeBy;
	private final String[] include;
	private final int price;
	private final boolean isEthical;
	private final boolean isInsurance;
	private final boolean isPsychotropic;


	Medicine(String type, String name, String madeBy, String[] include, 
			int price, boolean isEthical, boolean isInsurance, boolean isPsychotropic) {
		this.type = type;
		this.name = name;
		this.madeBy = madeBy;
		this.include = include;
		this.price = price;
		this.isEthical = isEthical;
		this.isInsurance = isInsurance;
		this.isPsychotropic = isPsychotropic;
	}
	
	Medicine(String type, String name, String madeBy, String[] include, 
			boolean isEthical, boolean isInsurance, boolean isPsychotropic) {
		this.type = type;
		this.name = name;
		this.madeBy = madeBy;
		this.include = include;
		this.isEthical = isEthical;
		this.isInsurance = isInsurance;
		this.isPsychotropic = isPsychotropic;
		this.price = 1;
	}
	
//	비보험약일경우 직접 가격을 결정하도록?
	public int getNonInsurPrice (int price) {
		if(this.isInsurance) {
			return this.price;
		} else {
			return price;
		}
	}
}
