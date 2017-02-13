
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
        $(".selectbox").select2();
        $("#updateFream").hide();
        $("#serMessage").hide();
        $("#bookBrowerInfo").hide();
        $("#bookRetInfo").hide();
        $("#serBookInfo").click(function(){
            updateFrameChk();
        });
        $("#delBookInfo").click(function(){
            delOp();
        });
        $("#serBrowBookInfo").click(function(){
            browBooksOp();
        });
        $("#serRetBookInfo").click(function(){
            retBooksOp();
        });
    });

    function  getObjsByClass (param) {
        var tags = tags || document.getElementsByTagName("*");
        var list = [];
        for( var k in tags)
        {
            var tag = tags[k];
            if(tag.type == param) {
                //document.write(tag.innerHTML);
                list.push(tag);
            }
        }
        return list;
    }

    function showSerMessage(){
        $("#serMessage").fadeIn("fast");
    }

    function hideSerMessage(){
        $("#serMessage").fadeOut("fast");

    }

    function hideSerMessageTimer(){
        var timer = setTimeout("hideSerMessage()", 3000);
    }

function updateFrameChk(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        var bookId = document.getElementById("bookId");
        bookId.value = tabler.rows[1].cells[0].innerText;
        bookId.click();

        var newbookName = document.getElementById("bookName");
        newbookName.value = tabler.rows[1].cells[1].innerText;
        newbookName.click();
        
        var newBookAuthor = document.getElementById("bookAuthor");
        newBookAuthor.value = tabler.rows[1].cells[2].innerText;
        newBookAuthor.click();
        
        var newBookPrice = document.getElementById("bookPrice");
        newBookPrice.value = tabler.rows[1].cells[3].innerText;
        newBookPrice.click();

        var newPubCompany = document.getElementById("bookPubCompany");
        newPubCompany.value = tabler.rows[1].cells[4].innerText;
        newPubCompany.click();

        var newBookAmount = document.getElementById("bookAmount");
        newBookAmount.value = tabler.rows[1].cells[5].innerText;
        newBookAmount.click();

        var newBookNum = document.getElementById("bookNum");
        newBookNum.value = tabler.rows[1].cells[6].innerText;
        newBookNum.click();

        var newBookRecordDate = document.getElementById("bookRecordDate");
        newBookRecordDate.value = tabler.rows[1].cells[7].innerText;
        newBookRecordDate.click();
        
        var newBookTags = document.getElementById("bookTags");
        newBookTags.value = tabler.rows[1].cells[8].innerText;
        newBookTags.click();

        $("#updateFream").slideDown("fast");
    }
    //rows[rowID].cells[colID].innerText
}
//tabler.rows.length


function delOp(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        $.messager.confirm("删除", "确定删除吗!?", function() {
        //删除之后的跳转操作

        });
    }
}

function browBooksOp(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        $("#bookBrowerInfo").slideDown("fast");
        document.getElementById("browBookId").value = tabler.rows[1].cells[0].innerText;
        document.getElementById("browBookName").value = tabler.rows[1].cells[1].innerText;
        document.getElementById("browBookAuthor").value = tabler.rows[1].cells[2].innerText;
    }
}

function retBooksOp(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        var flag = 0;
        var i = 1;
        var x = tabler.rows[1].cells[0].innerText;
        var tBrowedBooks = document.getElementById("browBookInfo");
        for(i = 1; i < tBrowedBooks.rows.length; i ++){
            if(x == tBrowedBooks.rows[i].cells[1].innerText){
                flag = 1;
                break;
            }
        }
        if(flag){
            $("#bookRetInfo").slideDown("fast");
            document.getElementById("retManageBookId").value = tBrowedBooks.rows[i].cells[0].innerText;
            document.getElementById("retBookId").value = tBrowedBooks.rows[i].cells[1].innerText;
            document.getElementById("retBookName").value = tBrowedBooks.rows[i].cells[2].innerText;
            document.getElementById("retBookAuthor").value = tBrowedBooks.rows[i].cells[3].innerText;
            document.getElementById("retBookPublishCompany").value = tBrowedBooks.rows[i].cells[5].innerText;
            document.getElementById("retBookTime").value = tBrowedBooks.rows[i].cells[6].innerText;
        }else{
            alert("你没借过这本书呀。");
        }
    }
}
