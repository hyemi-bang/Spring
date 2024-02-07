console.log('hi!');

const div1 = document.querySelector('#div1');
const div2 = $('#div2');

console.log(div1);
console.log(div2);

div2.addClass('btn');
div2.addClass('warning');

div2.click((e)=> {
    console.log(e);
    console.log('div2 clicked@@');
});

const ajaxBtn = $('#ajax-btn');

ajaxBtn.click((e) => {
    /*
     url : 요청 주소
     method : 요청 방식
     dataType : 요청 성공 후 받을 데이터 타입
     success: Ajax 응답을 성공적으로 받았을 때 콜백메서드 정의
    */
    const ajazSettings = {
        url: 'employee/101',
        method : 'GET',
        dataType: 'json',
        success: (emp, state, xhttp) => {
            console.log('전달받은데이터:', emp);
            console.log('상태코드:', state);
            console.dir(xhttp);
        }
        /*
        jquery-3.7.1.min.js:2 
        GET http://localhost:9000/springrest/jquery/employee/101 404 (Not Found)
        -> controller에 가서 @GetMapping("/employee/{emp_id}") emp101번 사원에 대한 
        매핑을 만들어준다.
        */
    };
    $.ajax(ajazSettings);
     // $.ajax({});원래 이렇게 사용한다고함
     //이 위치에 ajax Setting이라는 오브젝트가 들어가야한다. ajazSettings 이건 임의의 메서드명
});