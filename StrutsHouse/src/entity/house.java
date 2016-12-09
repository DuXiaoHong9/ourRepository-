package entity;

import java.io.Serializable;
import java.util.Date;


//@Entity
//@Table(name="HOUSE")
public class house implements Serializable{

	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_house")
//	@SequenceGenerator(name="seq_house",sequenceName="house_house_id")
	private Long id;//房屋编号
	//多对一  
//	@ManyToOne
//	@JoinColumn(name="USER_ID")
	private users users;//用户对象
//	@ManyToOne
//	@JoinColumn(name="TYPE_ID")
	private types types;//类型对象
//	@ManyToOne
//	@JoinColumn(name="STREET_ID")
	private street street;//街道对象
//	@Column(name="TITLE")
	private String title;//标题
//	@Column(name="DESCRIPTION")
	private String description;//描述
//	@Column(name="PRICE")
	private Double price;//价格
//	@Column(name="PUBDATE")
	private Date pubdate;//发布日期
//	@Column(name="FLOORRAGE")
	private Double floorrage;//面积
//	@Column(name="CONTACT")
	private String contact;//联系人
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public users getUsers() {
		return users;
	}
	public void setUsers(users users) {
		this.users = users;
	}
	public types getTypes() {
		return types;
	}
	public void setTypes(types types) {
		this.types = types;
	}
	public street getStreet() {
		return street;
	}
	public void setStreet(street street) {
		this.street = street;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public Double getFloorrage() {
		return floorrage;
	}
	public void setFloorrage(Double floorrage) {
		this.floorrage = floorrage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public house() {}
	
	public house(entity.users users, entity.types types, entity.street street,
			String title, String description, Double price, Date pubdate,
			Double floorrage, String contact) {
		this.users = users;
		this.types = types;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorrage = floorrage;
		this.contact = contact;
	}
	
	public house(entity.users users, entity.types types, entity.street street,
			String title, String description, Double price, Double floorrage,
			String contact) {
		this.users = users;
		this.types = types;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.floorrage = floorrage;
		this.contact = contact;
	}
	public house(entity.users users, entity.types types, entity.street street) {
		this.users = users;
		this.types = types;
		this.street = street;
	}
	
	public house(entity.types types, entity.street street, String title,
			String description, Double price, Date pubdate, Double floorrage,
			String contact) {
		this.types = types;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorrage = floorrage;
		this.contact = contact;
	}
	public house(Long id, entity.users users, entity.types types,
		entity.street street, String title, String description, Double price,
		Date pubdate, Double floorrage, String contact) {
	this.id = id;
	this.users = users;
	this.types = types;
	this.street = street;
	this.title = title;
	this.description = description;
	this.price = price;
	this.pubdate = pubdate;
	this.floorrage = floorrage;
	this.contact = contact;
}
}
