//Hàm kiểm tra class

/**
 * Hàm kiểm tra dữ liệu đầu vào của ô nhập class có bị bỏ trống hay không.
 * @param classes Giá trị class trong ô nhập
 * @param p_id Id của thẻ p (dùng để trả về thông tin khi kiểm tra đầu vào).
 * @returns {boolean} Trả về True nếu ô nhập lớp đã được nhập và false nếu chưa được nhập.
 */
function checkInputClass(classes,p_id){
	if(classes == 0){
		document.getElementById(p_id).innerHTML = "Not be empty"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
		return false;
	}else {
		document.getElementById(p_id).innerHTML = ""
	}
	return true;
}


//Hàm kiểm tra tên đầu vào
/**
 * Hàm kiểm tra tên sinh viên có bị bỏ trống hay không và
 * Độ dài của tên có vượt quá số lượng cho phép hay không.
 * @param name Giá trị của ô nhập tên sinh viên
 * @param p_id Id của thẻ p (dùng để trả về thông tin khi kiểm tra đầu vào).
 * @returns {boolean} Trả về True nếu ô nhập tên sinh viên đã được nhập và false nếu chưa được nhập.
 */
function checkInputName(name,p_id){
	var check=true;
	if(name===""){
		check=false;
		document.getElementById(p_id).innerHTML = "Not be empty"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
	}else if(name.length>25){
		check=false;
		document.getElementById(p_id).innerHTML = "Do not enter more than 30 characters"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
	}
	else{
		document.getElementById(p_id).innerHTML = ""
	}
	console.log(check)
	return check;
}


//Hàm kiểm tra ngày sinh
/**
 * Hàm kiểm tra ngày tháng năm sinh của sinh viên có bị bỏ trống hay không
 * hoặc chưa đúng định dạng hay không.
 * @param date Giá trị của ô nhập ngày tháng năm sinh
 * @param p_id Id của thẻ p (dùng để trả về thông tin khi kiểm tra đầu vào).
 * @returns {boolean} Trả về True nếu ô nhập ngày tháng năm sinh của sinh viên đã được nhập và false nếu chưa được nhập.
 */
function checkInputDate(date,p_id){
	var check=true;
	const pattern = /\d{1,2}[-|/]\d{1,2}[-|/]\d{4}/g;
	let result = pattern.test(date);
	if(date===""){
		check=false;
		document.getElementById(p_id).innerHTML = "Not be empty"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
	}else if(result==false){
		check=false;
		document.getElementById(p_id).innerHTML = "Please enter the true format dd / mm / yyyy"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
	}else{
		document.getElementById(p_id).innerHTML = ""
	}
	console.log(check)
	return check;
}

//Hàm kiểm tra giới tính/
/**
 * Kiểm tra giới tính của sinh viên đã được chọn hay chưa.
 * @param p_sex_id Id của thẻ p (dùng để trả về thông tin khi kiểm tra đầu vào).
 * @param r_m_id ID của ô nữ
 * @param r_f_id ID của ô nam
 * @returns {boolean} Trả về giá trị true nếu ô đac được chọn và false nếu chưa được chonj
 */
function checkInputSex(p_sex_id,r_m_id,r_f_id){
	
	var check=true;
	var sex;
	var  rmid=document.getElementById(r_m_id);
	var  fmid=document.getElementById(r_f_id)
	
    if (rmid != null && rmid.checked){
		check=true;
        sex = true;
		document.getElementById(p_sex_id).innerHTML = ""
    } else if (fmid != null && fmid.checked) {
		check=true;
        sex = false;
		document.getElementById(p_sex_id).innerHTML = ""
    }else{
		check=false;
		document.getElementById(p_sex_id).innerHTML = "Not be empty"
		document.getElementById(p_sex_id).style.color = "red"
		document.getElementById(p_sex_id).style.fontSize="12px";
	}
	
	return check;
	
}

/**
 * Hàm kiểm tra số điện thoại đã được nhập hay chưa
 * Kiểm tra xem có đúng định dạng số điện thoại : gồm 10 số, số 0 đứng đầu hay không
 * @param phone Giá trị của ô nhập số điện thoại
 * @param p_id  Id của thẻ p (dùng để trả về thông tin khi kiểm tra đầu vào).
 * @returns {boolean} Trả về true nếu số điện thoại đã được nhập và đúng định dạngvaf
 * trả về false nếu chưa được nhập hoặc nhập sai định dạng
 */
//Hàm kiểm tra định dạng số điện thoại
function checkInputPhone(phone,p_id){
	var check = true;
	var regE = /0\d{9}/g;
	let results = regE.test(phone);
	if(phone===""){
		console.log(p_id)
	   document.getElementById(p_id).innerHTML = "Not be empty"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
		check=false;
	}else if(phone.length>10){
		document.getElementById(p_id).innerHTML = "Do not enter more than 10 characters"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
		check=false;
	}
	else if(results==false){
		document.getElementById(p_id).innerHTML = "Please enter the true format"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
		
		check=false;
	}else{
		document.getElementById(p_id).innerHTML = ""
	}
	return check;
	
}



//Hàm Batch
/**
 *Hàm nhập nhanh dữ liệu vào bảng
 */
function batchInput(){
	var b_cl = document.getElementById("b-class");
	var b_classes = b_cl.options[b_cl.selectedIndex].value
	var b_class_text = b_cl.options[b_cl.selectedIndex].text
	var fullname = document.getElementById("b-name").value
	var dateOfBirth = document.getElementById("b-date").value
	var phonenumber = document.getElementById("b-phone").value
	var note = document.getElementById("b-note").value

	
	var sex;
	if (document.getElementById("r-b-male").checked) {
        sex = true
    } else if (document.getElementById("r-b-female").checked) {
        sex = false
    }else{
		sex = null;
	}
	

		for(let i = 1;i<=10;i++){
			var cl = document.getElementById("class"+i);
			var classes = cl.options[cl.selectedIndex].value = b_classes
			cl.options[cl.selectedIndex].text = b_class_text;
			console.log("batch class: "+cl)
			document.getElementById("name"+i).value = fullname
			document.getElementById("date"+i).value = dateOfBirth
			document.getElementById("phone"+i).value = phonenumber
			document.getElementById("note"+i).value = document.getElementById("b-note").value
			if(sex){
				document.getElementById("r-male"+i).checked = true
				document.getElementById("r-female"+i).checked = false
			}else if(sex==null){
				document.getElementById("r-male"+i).checked = false
				document.getElementById("r-female"+i).checked = false
			}else{
				document.getElementById("r-male"+i).checked = false
				document.getElementById("r-female"+i).checked = true
			}
			
			document.getElementById("phone"+i).value = phonenumber
			document.getElementById("note"+i).value = note
		}
		

	
}

/**
 * Hàm xóa dữ liệu trên màn hình của các hàng được chọn
 */
function deleteRow(){

	var scope = document.getElementsByName("checkbox")
	var checkscope = $('th[name="checkbox"]').prop('checked', true);
	if(checkscope.length==0){
		alert("Please choose one or more row to delete")
	}
	for(let i=0;i<scope.length;i++){
		var classes = document.getElementById("class"+scope[i].id);

		var name = document.getElementById("name"+scope[i].id)
		var	date = document.getElementById("date"+scope[i].id) 
		var	phone = document.getElementById("phone"+scope[i].id)
		var	note = document.getElementById("note"+scope[i].id)
		
		if(scope[i].checked==true){
			classes.options[classes.selectedIndex].value = ""
			classes.options[classes.selectedIndex].text = "Class"
		//	classes.selectedIndex.text = "Class"
			name.value =""
			date.value =""
			phone.value =""
			note.value =""
			document.getElementById("r-male"+scope[i].id).checked = false
			document.getElementById("r-female"+scope[i].id).checked = false
			
			//xóa nội dung các thẻ thông báo
			document.getElementById("p-class"+scope[i].id).innerHTML = ""
			document.getElementById("p-name"+scope[i].id).innerHTML = ""
			document.getElementById("p-date"+scope[i].id).innerHTML = ""
			document.getElementById("p-phone"+scope[i].id).innerHTML = ""
			document.getElementById("p-note"+scope[i].id).innerHTML = ""
			document.getElementById("p-sex"+scope[i].id).innerHTML = ""
			
			
			
		}
	}
}


function checkAllBox(){
	var checkboxes = document.getElementsByName('checkbox');
        // Lặp và thiết lập checked
	
        for (var i = 0; i < checkboxes.length; i++){
			if(checkboxes[i].checked == true){
				checkboxes[i].checked = false;
			}else{
				checkboxes[i].checked = true;
			}
            
         }
}

/**
 * Hàm check tên và ngày tháng năm sinh của sinh có bị trùng với sinh viên đã tồn tại trong cơ sở dữ liệu hay không.
 * @param student Đối tượng sinh viên
 * @param name Tên sinh viên
 * @param date Ngày tháng năm sinh của sinh viên
 * @returns {boolean} Trả về true nếu thông tin sinh viên thêm mới không bị trùng và trả về false nếu bị trùng.
 */
function checkInputBE(student,name,date){
	var check = true;
	fetch('/inputCheck',{
		method : "PUT",
		body: JSON.stringify(student),
		headers: {
			"Content-Type": "application/json",
		}

	}).then((response)=>{
		console.log('resovle',response);
		response.json().then(data => {
			console.log(data);
			if(data == false){
				alert(name +"-"+ date + " Already exist!");
				check = false;
			}
		})

	}).catch((err)=>{
		console.log('rejected',err);
	})
	return check
}
function checkInputNote(note,p_id){
	var check = true;
	if(note.length>50){
		check=false;
		document.getElementById(p_id).innerHTML = "Do not enter more than 50 characters"
		document.getElementById(p_id).style.color="red";
		document.getElementById(p_id).style.fontSize="12px";
	}else {
		document.getElementById(p_id).innerHTML = ""
	}
	return check;
}
/**
 * Hàm thêm mới một danh sách sinh viên vào cơ sở dữ liệu
 */
function register() {
	var duplicatecount = 0;
	var check_FE = 0//đếm các sinh viên trên màn hình chưa thỏa mãn các hàm kiểm tra đầu vào
	var duplicate = [];// mảng chưa các sinh viên trùng lặp trên màn hình
	const students = [];//mảng chứa các sinh viên
	var count_checkDB = 0;//Biến đếm số sinh viên trong danh sách có tên và ngày tháng năm sinh bị trùng với sinh viên
						//trong cơ sở dữ liệu
	var count = 0;//biến kiểm tra toàn bộ 10 hàng có rỗng hay k?
	var done = true;//biến check xem có đủ điều kiện đăng kí không
	for (let i = 1; i <= 10; i++) {
		var cl = document.getElementById("class" + i);
		var classes = cl.options[cl.selectedIndex].value
		let name = document.getElementById("name" + i).value
		let date = document.getElementById("date" + i).value
		let phone = document.getElementById("phone" + i).value
		let note = document.getElementById("note" + i).value
		console.log(classes )
		var sex;
		/**
		 * Kiểm tra các dòng người dùng nhập thông tin sinh viên để thêm vào cơ sở dữ liệu
		 */
		if (classes == "" && name == "" && date == "" && phone == "" && note == "") {
			count++;
			continue;
		} else {

			//validate dữ liệu nhập vào
			/**
			 * Gọi hàm kiểm tra dữ liệu đầu vào
			 * @type {boolean}
			 */
			let checkClasses = checkInputClass(classes, "p-class" + i)
			let checkName = checkInputName(name, "p-name" + i)
			let checkDate = checkInputDate(date, "p-date" + i);
			sex = checkInputSex("p-sex" + i, "r-male" + i, "r-female" + i);

			//alert(phone)
			let checkPhone = checkInputPhone(phone, "p-phone" + i);
			let checkNote = checkInputNote(note,"p-note"+i);

			//check trùng trên màng hình
			/**
			 * Kiểm tra thông tinsinh viên trên màn hình có bị trùng nhau không
			 */
			for (let j = i + 1; j <= 10; j++) {
				let cl = document.getElementById("class" + j);
				let classes = cl.options[cl.selectedIndex].value
				let name = document.getElementById("name" + j).value
				let date = document.getElementById("date" + j).value
				let phone = document.getElementById("phone" + j).value
				let note = document.getElementById("note" + j).value
				if(classes != "" && name != "" && date != "" && phone != "" && note != ""){
					if (name == document.getElementById("name" + j).value && date == document.getElementById("date" + j).value) {
						duplicatecount++;
						duplicate.push(i)

					}
				}
			}

			if (checkName == false || checkDate == false || sex == false || checkPhone == false || checkClasses == false|| checkNote == false) {
				check_FE ++;

			}
		}


		var student = {
			class_id: {
				id: classes
			},
			fullname: name,
			sex: sex,
			phone: phone,
			note: note,
			dateofbirth: date


		}
		/**
		 * Gọi hàm tra sinh viên nhập vào có bị trùng với sinh viên đã tồn tại trong cơ sở dữ liệu hay không.
		 * @type {boolean}
		 */
		var checkBE = checkInputBE(student,name,date);
		if(checkBE == false){
			console.log("checkDB_count:"+checkBE)
			return}

		students.push(student)
		console.log(students)
	}

	if (duplicatecount > 0) {
		for (let i of duplicate) {
			document.getElementById("p-name" + i).innerHTML = "Name and Date of birth is duplicate!";
			document.getElementById("p-name" + i).style.color = "red";

			document.getElementById("p-date" + i).innerHTML = "Name and Date of birth is duplicate!";
			document.getElementById("p-date" + i).style.color = "red";
			console.log("Name and Date of birth is duplicate!")
			done = false;
		}
	}



	if (count == 10)  {
		done = false;
		alert("Please enter one or more row to register!")
	}
	if(check_FE > 0){
		done = false;
	}
	/**
	 * Thêm danh sách sinh viên vào cơ sở dữ liệu
	 */

	if (done == true && count_checkDB == 0) {
		console.log(count_checkDB)

		// console.log(students[0].fullname)
		// $.ajax({
		// 		url: 'listStudents',
		// 		type: 'POST',
		// 	contentType: "application/json",
		// 		data: JSON.stringify({
		// 			studentDtoList : students
		// 		}),
		// 		success: function (data){
		// 			console.log(data)
		// 		}
		// 	}
		//
		// )

///Thêm student
		fetch('/listStudents', {
			method: "POST",

			body: JSON.stringify(students),
			headers: {
				"Content-Type": "application/json",
			}
		}).then(
			function (response) {
				if (response.status !== 200) {
					console.log('Error  ' + response.status);
					alert("Happening error!")
					return;
				}
				// parse response data
				response.json().then(data => {
					console.log(data);
					alert("Register Successfully!")
				})
			}
		)


	}
}