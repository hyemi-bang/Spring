
const json1 = document.getElementById('json1');

json1.addEventListener('click', (e) => {

    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) => {
        if (xhttp.status == 200 && xhttp.readyState == 4) {

            const cargo = xhttp.responseText;
            const obj = JSON.parse(cargo);

            console.log(obj);

            for (let i = 0; i < obj.length; i++) {
                console.log('1 : ', obj[i].employee_id);
                console.log('2 : ', obj[i].first_name);
                console.log('3 : ', obj[i].last_name);
            }

            for (let i = 0; i < obj.length; i++) {
                const empId = document.createElement('div');
                const empFname = document.createElement('div');
                const empLname = document.createElement('div');
                console.log(2);
                empId.innerText += obj[i].employee_id;
                empFname.innerText += obj[i].first_name;
                empLname.innerText += obj[i].last_name;
                randomEmployeesJson.appendChild(empId);
                randomEmployeesJson.appendChild(empFname);
                randomEmployeesJson.appendChild(empLname);
            }
        }
    })
    xhttp.open('GET', './quiz/jsonQ');
    xhttp.send();
})

const xml1 = document.getElementById('xml1');

xml1.addEventListener('click', (e) => {
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) => {
       if (xhttp.readyState == 4 && xhttp.status == 200) {

            const cargo = xhttp.responseXML;
            console.log(cargo)

            const cargo2 = cargo.getElementsByTagName('item');

            for (let i = 0; i < cargo2.length; i++) {

                for (let j = 0; j < cargo2[i].children.length; j++) {
                    const emps = document.createElement('div');
                    emps.innerText += cargo2[i].children[j].innerHTML;           
                    randomEmployeesXml.appendChild(emps);
                }
            }
        }
    })
    xhttp.open('GET', './quiz/xmlQ');
    xhttp.send();
})

const randomEmployeesJson = document.getElementById('randomEmployeesJson');
const randomEmployeesXml = document.getElementById('randomEmployeesXml');