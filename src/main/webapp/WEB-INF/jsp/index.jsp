<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>hoover - &copy; hoover</title>
    <link href="<%=basePath %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>/static/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <script src="<%=basePath %>/static/js/jquery-2.0.3.min.js"></script>
    <script src="<%=basePath %>/static/js/fileinput.js" type="text/javascript"></script>
    <script src="<%=basePath %>/static/js/fileinput_locale_zh.js" type="text/javascript"></script>
    <script src="<%=basePath %>/static/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<%=basePath %>-----------------

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header" >
            <a class="navbar-brand">Qmx</a>
        </div>
    </div>
</nav>
<div class="container kv-main">
    <div class="page-header" style="padding-top: 40px;">
        <h1>Image Upload </h1>
        <h2 class="text-success">2 MB max per file. </h2>
    </div>

    <br>
    <form enctype="multipart/form-data">

        <br>

        <div class="form-group">
            <input id="file-1" type="file"   data-overwrite-initial="false" data-min-file-count="1" name="file">
        </div>

    </form>

    <div id="showurl" style="display: none;">
        <ul id="navTab" class="nav nav-tabs">
            <li class="active"><a href="#urlcodes" data-toggle="tab">URL</a></li>
            <li><a href="#htmlcodes" data-toggle="tab">HTML</a></li>
            <li><a href="#bbcodes" data-toggle="tab">BBCode</a></li>
            <li><a href="#markdowncodes" data-toggle="tab">Markdown</a></li>
            <li><a href="#markdowncodes2" data-toggle="tab">Markdown with Link</a></li>
            <li><a href="#deletepanel" data-toggle="tab">Delete Link</a></li>
        </ul>
        <div id="navTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="urlcodes">
                <pre style="margin-top: 5px;"><code id="urlcode"></code></pre>
            </div>
            <div class="tab-pane fade" id="htmlcodes">
                <pre style="margin-top: 5px;"><code id="htmlcode"></code></pre>
            </div>
            <div class="tab-pane fade" id="bbcodes">
                <pre style="margin-top: 5px;"><code id="bbcode"></code></pre>
            </div>
            <div class="tab-pane fade" id="markdowncodes">
                <pre style="margin-top: 5px;"><code id="markdown"></code></pre>
            </div>
            <div class="tab-pane fade" id="markdowncodes2">
                <pre style="margin-top: 5px;"><code id="markdownlinks"></code></pre>
            </div>
            <div class="tab-pane fade" id="deletepanel">
                <pre style="margin-top: 5px;"><code id="deletecode"></code></pre>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="">提示！</h4>
            </div>
            <div class="modal-body" style="text-align:  center;">
                <label id="myModalLabel"></label>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>确定</button>
            </div>
        </div>
    </div>
</div>

</body>
<script>

    $("#file-1").fileinput({
        language: 'zh', //设置语言
        //allowedFileTypes: ['image', 'video', 'flash'],
        uploadUrl: 'file/uploads', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
        overwriteInitial: false,
        uploadAsync: true, //默认异步上传
        showUpload: true, //是否显示上传按钮
        showRemove : true, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        maxFileSize: 2048,
        maxFilesNum: 10,
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
    }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功
        var form = data.form, files = data.files, extra = data.extra,
            response = data.response, reader = data.reader;
        console.log('文件上传成功！'+data.code+data.data);

        if(response.code == '200') {
            if (response.data.url) {
                $("#showurl").show();
                $('#urlcode').append(response.data.url + "\n");
                $('#htmlcode').append("&lt;img src=\"" + response.data.url + "\" alt=\"" + files[index].name + "\" title=\"" + files[index].name + "\" /&gt;" + "\n");
                $('#bbcode').append("[img]" + response.data.url + "[/img]" + "\n");
                $('#markdown').append("![" + files[index].name + "](" + response.data.url + ")" + "\n");
                $('#markdownlinks').append("[![" + files[index].name + "](" + response.data.url + ")]" + "(" + response.data.url + ")" + "\n");
                $('#deletecode').append(response.data.delete + "\n");
            }
        }else{
            $('#myModalLabel').html(response.msg);
//            alert("图片上传失败！");
            $('#myModal').modal();
        }

    }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
        console.log('图片上传失败！'+data);


    });
    /*
    $(".file").on('fileselect', function(event, n, l) {
        alert('File Selected. Name: ' + l + ', Num: ' + n);
    });
    */

    $(document).ready(function() {

    });

</script>
</html>