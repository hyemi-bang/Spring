
const out = document.querySelector('#out');
const btn1 = document.querySelector('#btn1');

btn1.addEventListener('click', (e) => {
    // Ajax 요청 객체 생성
    const xhttp = new XMLHttpRequest();

    /*
    xhttp.open('GET', './rest/v1');
    */

    // readystatechange 이벤트 리스너 설정
    // : xhttp 객체의 상태가 변화할때마다 발생하는 이벤트를 설정해둔다
    xhttp.addEventListener('readystatechange', (e) => {
        //console.dir(e);

        // readyState 1 : open()이 성공했을때 (send()하기 전)
        // readyState 2 : 요청에 대한 응답이 도착했을 때
        // readyState 3 : 응답에 대한 처리르 시작했을 때
        // readyState 4 : 응답에 대한 처리가 모두 끝났을 때 (사용 준비완료)

        // console.dir(xhttp.readyState); 

        // open이 먼저 있을때 consloe -> 2 3 4 
        // open이 뒤에 있을때 consloe -> 1 2 3 4 

        // 즉 readyState 4번 일때만 사용하면 된다.
        if (xhttp.readyState === 4){
            // @RestController로 부터 응답받은 데이터는 responseText에 들어있다
            // console.log(xhttp.responseText);

            // @RestController에서 받아온 데이터를 화면에 반영할 수 있다
            //out.innerHTML += xhttp.responseText;
            
            out.innerHTML += '<div>' +  xhttp.responseText + '<div>';
        }
    });

    //  open(method, uri) : 요청을 어떤 방식으로 어디에 보낸지 설정
    xhttp.open('GET', './rest/v1');


    // 요청을 보낸다 (location.href와 다르게 다음 페이지로 넘어가지 않는다)
    xhttp.send();
});

const btn2 = document.querySelector('#btn2'); // JSON
const emps = document.querySelector('#employees');
const btn3 = document.querySelector('#btn3'); // XML

btn2.addEventListener('click', (e)=>{
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e)=>{
        if(xhttp.readyState === 4 && xhttp.status == 200){
            console.dir(xhttp); 
            console.log(xhttp.responseText); //  {"employee_id":11,"first_name":"자바","last_name":"김"}

            const cargo = xhttp.responseText;
            // JSON은 Javascript Object 형식의 문자열이지 오브젝트가 아니다
            // 오브젝트로 변환하는 과정이 필요하다
            console.log(cargo);
            console.log(typeof cargo); // string

            // Java으로 전달받은 Java의 데이터를 자바스크립트 오브젝트로 변환하여 활용
            const obj = JSON.parse(cargo);
            console.log(obj);
            console.log("employee_id: " , obj.employee_id);
            console.log("first_name: " , obj.first_name);
            console.log("last_name: " , obj.last_name);

            const newEmpId = document.createElement('div');
            const newFname = document.createElement('div');
            const newLname = document.createElement('div');

            newEmpId.classList.add('emp-id');
            newFname.classList.add('emp-fname');
            newLname.classList.add('emp-lname');

            newEmpId.innerText = obj.employee_id;
            newFname.innerText = obj.first_name;
            newLname.innerText = obj.last_name;

            emps.appendChild(newEmpId);
            emps.appendChild(newFname);
            emps.appendChild(newLname);

        }
    });

    xhttp.open('GET', './rest/v4');
    xhttp.send();
});

btn3.addEventListener('click', (e)=>{
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e)=> {
        if(xhttp.status == 200 & xhttp.readyState == 4){
            console.log(xhttp.responseText);
            /*
             <EmployeeDTO><employee_id>18</employee_id><first_name>자바</first_name>
             <last_name>심</last_name></EmployeeDTO>
             */

             
            //responseXML로 전달받은 XML데이터를 docuement처럼 사용할 수 있다.
             console.log(xhttp.responseXML);

             const xmlDoc = xhttp.responseXML;
             //const employee = xmlDoc.getElementsByTagName('EmployeeDTO');
             //const firstNames = xmlDoc.getElementsByTagName('first_name');
             const emps = xmlDoc.getElementsByTagName('item');

             //console.log(employee);
             //console.log(firstNames);

             console.log(emps);

             for(let i = 0 ; i < emps.length; ++i){
                console.log(`### emp${i} ###`);
                 const fields = emps[i].children;

                for(let j = 0 ; j < fields.length; ++j){
                    //console.log(children[j]);
                    console.log(fields[j].tagName, ':', fields[j].innerHTML);
                }
             }
        }
    });
    //xhttp.open('GET', './rest/v5');
    xhttp.open('GET', './rest/v6');
    xhttp.send();
});