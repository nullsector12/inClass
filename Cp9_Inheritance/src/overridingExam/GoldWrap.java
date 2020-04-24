package overridingExam;

// PaperWrap 클래스의 자손 => GoldWrap
public class GoldWrap extends PaperWrap{
	
	public void goldWrap() {
		System.out.println("gold wrap");
	}

	@Override
	public void wrap() {
		System.out.println("gold wrap");
	}

	
	
}
