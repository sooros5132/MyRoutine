package com.myroutine.web.entity.admin.achievement;

import java.util.Date;

public class Achievement {

	 	private int id;
	    private String title;
	    private String contents;
	    private Date regdate;
	    private String type;
	    private int goal_rate;
	    private int achievement_rate;
	    private int reward;
	    private String member_id;
	    
		public Achievement() {
			
		}
		public Achievement(int id, String title, String contents, Date regdate, String type, int goal_rate,
				int achievement_rate, int reward, String member_id) {
			super();
			this.id = id;
			this.title = title;
			this.contents = contents;
			this.regdate = regdate;
			this.type = type;
			this.goal_rate = goal_rate;
			this.achievement_rate = achievement_rate;
			this.reward = reward;
			this.member_id = member_id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public Date getRegdate() {
			return regdate;
		}
		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getGoal_rate() {
			return goal_rate;
		}
		public void setGoal_rate(int goal_rate) {
			this.goal_rate = goal_rate;
		}
		public int getAchievement_rate() {
			return achievement_rate;
		}
		public void setAchievement_rate(int achievement_rate) {
			this.achievement_rate = achievement_rate;
		}
		public int getReward() {
			return reward;
		}
		public void setReward(int reward) {
			this.reward = reward;
		}
		public String getMember_id() {
			return member_id;
		}
		public void setMember_id(String member_id) {
			this.member_id = member_id;
		}
		@Override
		public String toString() {
			return "achievement [id=" + id + ", title=" + title + ", contents=" + contents + ", regdate=" + regdate
					+ ", type=" + type + ", goal_rate=" + goal_rate + ", achievement_rate=" + achievement_rate
					+ ", reward=" + reward + ", member_id=" + member_id + "]";
		}
	    
	    
}
