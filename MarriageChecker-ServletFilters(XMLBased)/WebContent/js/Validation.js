function validate(frm){
	
	
	//Empty the existing form validation error message
	
	
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	document.getElementById("paddressErr").innerHTML="";
	
	
		//read form data
		let name=frm.pname.value;
		let age=frm.page.value;
		let address=frm.paddress.value;
		let flag=true;
		
		//client side form validation
		
		//validation on name
		if(name==""){
			flag=false;
			document.getElementById("pnameErr").innerHTML="Person name is required";
			frm.pname.focus();
		}
		else if(name.length<5){
			flag=false;
			document.getElementById("pnameErr").innerHTML="Person name should have minimum length of 5";
			frm.pname.focus();
		}
		
		//validation on age
		// required, number and range rule on age
		if(age==""){
			flag=false;
			document.getElementById("pageErr").innerHTML="Person age is required";
			frm.page.focus();
		}
		else if(isNaN(age)){
			flag=false;
			document.getElementById("pageErr").innerHTML="Person age is not a number";
			frm.page.focus();
		}
		else if(age<0 || age>125){
			flag=false;
			document.getElementById("pageErr").innerHTML="Person age must be between 1 and 125";
			frm.page.focus();
		}
		
		
		//validation on address
		if(address==""){
			flag=false;
			document.getElementById("paddressErr").innerHTML="Person address is required";
			frm.paddress.focus();//keep focus on paddress box
		}
		
		//change vflag(hidden box vlaue) to "yes" indicating that client side form validation are done
		
		frm.vflag.value="yes";
		
		return flag;	
		
		
	}