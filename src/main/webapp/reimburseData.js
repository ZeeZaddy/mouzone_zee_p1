let urlu = "http://localhost:8080/ERS/review";
// let p = document.getElementById(provideIDHere)

function getData(){

    let url = "http://localhost:8080/ERS/requestform";

//1.Create our XHR Object
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200){
            let response = JSON.parse(xhr.responseText);

            console.log(response);

            populateReim(response);
        }
    }



xhr.open('GET', url, true);

xhr.send();



function populateReim(res){
     let amount = document.getElementById('amount');

     let amountTable = document.createElement('table');
     amountTable.setAttribute('class', 'table')

     let tHead = document.createElement('thead');

     let tableHeaderrow = document.createElement('ts');



     for(let reimbursements of res){
        let tr = document.createElement('tr');

        let tdID = document.createElement('td');
        tdID.innerHTML = reimbursements.id;
        tr.append(tdID);

        let tdStatus = document.createElement('td');
        tdStatus.innerHTML = reimbursements.status;
        tr.append(tdStatus);

        let tdAuthor = document.createElement('td');
        tdAuthor.innerHTML = reimbursements.author.id;
        tr.append(tdAuthor);

        let tdAmount = document.createElement('td');
        tdAmount.innerHTML = reimbursements.amount;
        tr.append(tdAmount);

        let tdCert = document.createElement('td');
        tdCert.innerHTML = reimbursements.courseType;
        tr.append(tdCert);

//        let tdLocation = document.createElement('td');
//        tdLocation.innerHTML = reimbursements.location;
//        tr.append(tdLocation);

//        let tdDate = document.createElement('td');
//        tdDate.innerHTML = reimbursements.date;
//        tr.append(tdDate);

        let tdButtonaccept = document.createElement('td');
        tdButtonaccept.innerHTML = `<button type="button" onclick="accept(event)">Accept</button>`;
        tr.append(tdButtonaccept);

        let tdButtondeny = document.createElement('td');
        tdButtondeny.innerHTML = `<button type="button" onclick="deny(event)">Deny</button>`;
        tr.append(tdButtondeny);



        reimTable.append(tr);

     }
     reimDiv.append(reimTable);



}