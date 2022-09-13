function importTraffic(){
    let msg = beforeImport()
    if (msg !== ''){
        error(msg);
        return;
    }
    let data = {
        rootNo: $("#rootNo").val(),
        fileName: $('#fileName').val()
    }

    $.ajax({
        url: "/traffic/import",
        data: data,
        dataType: 'json',
        method: 'POST',
        success: function (result){
            if (result.success){
                Swal.fire("成功", "导入成功!", "success")
            }else{
                Swal.fire("失败", result.errMsg, "error")
            }
        }
    })
}

function error(msg){
    Swal.fire({
        icon: 'error',
        title: '错误',
        text: msg,
    })
}

function beforeImport() {
    //道路编号
    let rootNo = $("#rootNo").val();
    if (rootNo === '') {
        return "请输入道路编号!";
    }
    // 文件名
    let fileName = $("#fileName").val();
    if (fileName === '') {
        return '请选择需要上传的文件';
    }
    return "";
}