package bean;

public class UserBean {
	private String name;
	private boolean gender;// true代表男，false女
	private int age;
	private int limit;// 1超级管理员；2普通管理员；3版主；4会员；5游客

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
