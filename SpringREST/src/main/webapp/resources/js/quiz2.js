const listAll = document.querySelector('#listAll'); 
const fruitsJson = document.getElementById('fruitsJson');

listAll.addEventListener('click', (e)=>{
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener( 'readystatechange', (e) => {

        if(xhttp.status === 200 && xhttp.readyState === 4 ){
            const obj = JSON.parse(xhttp.responseText);
            console.log(obj);

            if (fruitsJson) {
                for (let i = 0; i < obj.length; i++) {
                    const fruitId = document.createElement('div');
                    const fruitName = document.createElement('div');
                    const fruitPrice = document.createElement('div');
                    const fruitGrade = document.createElement('div');
                    const countryId = document.createElement('div');

                    fruitId.innerHTML += obj[i].fruit_id;
                    fruitName.innerHTML += obj[i].fruit_name;
                    fruitPrice.innerHTML += obj[i].fruit_price;
                    fruitGrade.innerHTML += obj[i].fruit_grade;
                    countryId.innerHTML += obj[i].country_id;

                    fruitsJson.appendChild(fruitId);
                    fruitsJson.appendChild(fruitName);
                    fruitsJson.appendChild(fruitPrice);
                    fruitsJson.appendChild(fruitGrade);
                    fruitsJson.appendChild(countryId);
                }
            } else {
                console.error("Element with id 'fruitsJson' not found.");
            }
        }
    });
    xhttp.open('GET', './quiz2/fruits');
    xhttp.send();
});

const quiz2_1 = document.querySelector('#quiz2-1'); // 임의의 과일을 전달 (POST)
const quiz2_2 = document.querySelector('#quiz2-2');
const quiz2_3 = document.querySelector('#quiz2-3');

quiz2_1.addEventListener('click', (e)=>{
    const xhttp = new XMLHttpRequest();

    const newFruit ={
        fruit_name: 'Dragon Fruit',
        fruit_price: 3500,
        fruit_grade: 'A',
        country_id: 'BR'
    }
    // fruit_id는 시퀀스라 달지 않았다.

    xhttp.addEventListener('readystatechange', (e)=>{
        if(xhttp.readyState === 4 && xhttp.status == 200){
            console.log('insert success');
        }
    });

    xhttp.open('POST', './quiz2/fruit');
    xhttp.setRequestHeader('content-type', 'application/json'); 
    xhttp.send(JSON.stringify(newFruit));
});


const modifyFruitID = document.querySelector('#modify-fruit-id');
quiz2_2.addEventListener('click', (e)=>{
    const xhttp = new XMLHttpRequest();
    const fid = modifyFruitID.value;

    if(fid === null || fid =='' || fid < 0){
        alert('ID를 제대로 입력해주세요');
        return;
    }
    // 나은 방법이 있으면 고치래

    const modifyFruit = {
      fruit_id: fid,
      fruit_name: 'Strawberry',
      fruit_price: 700,
      fruit_grade:'C',
      country_id: 'AR',
    };

    xhttp.addEventListener('readystatechange', (e)=>{
        if(xhttp.readyState === 4 && xhttp.status == 200){
            console.log('Update Complete!');
        }

    });
    xhttp.open('PUT', `./quiz2/fruit/${fid}`);
    xhttp.setRequestHeader('content-type', 'application/json'); 
    // 안쓰면 Content type 'text/plain;charset=UTF-8' not supported] 이런 오류 메시지가온다. String 타입은 매핑할줄 모른다 ~ 
    xhttp.send(JSON.stringify(modifyFruit));
});