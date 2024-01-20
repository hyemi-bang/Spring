
const jsonBtn = document.querySelector('#jsonBtn');
const xmlBtn = document.querySelector('#xmlBtn');

jsonBtn.addEventListener('click', (e)=>{
    const xhttp = new XMLHttpRequest();

    xhttp.addEventListener('readystatechange', (e)=>{
        if(xhttp.status == 200 && xhttp.readyState == 4 ){

            const newEmpId = document.createElement('div');
            const newFname = document.createElement('div');
            const newLname = document.createElement('div');

            newEmpId.innerText = obj.employee_id;
            newFname.innerText = obj.first_name;
            newLname.innerText = obj.last_name;

            emps.appendChild(newEmpId);
            emps.appendChild(newFname);
            emps.appendChild(newLname);
            
        }
    });
    xhttp.open('GET', './quiz/json');
    xhttp.send();

});
