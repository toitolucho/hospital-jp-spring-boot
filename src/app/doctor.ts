export interface Doctor{
	/*private Hospital hospital;
	@Column(name = "FirstName")
	private String names;
	@Column(name = "LastNames")
	private String lastNames;
	@Column(name = "DateOfBirth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	@Column(name = "Address")
	private String adress;
	@Column(name = "PictureFile")
	private String pictureFile; */
	id: number;
	names : string;
	lastNames : string;
	dateOfBirth : string;
	address :string;
	pictureFile : string;
	
}