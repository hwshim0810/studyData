package java.pracextends;

public class SampleChild extends SampleParent {
	
	public SampleChild(String parentMember) {
		super(parentMember);
	}
	
	@Override
	public void setParentMember(String parentMember) {
		this.parentMember = parentMember + "!";
	}
}
