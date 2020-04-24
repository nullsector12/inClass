package overridingExam;

// Box 클래스의 자손 => PaperWrap 
public class PaperWrap extends Box {
	public void paperWrap() {
		System.out.println("paper wrap");
	}

	@Override
	public void wrap() {
		System.out.println("paper wrap");
	}

}
