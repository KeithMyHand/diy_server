<%@ page contentType = "text/html;charset=gb2312" import="com.keith.diy.*"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%
			User user = new User(1, "n222", "p222");
			out.println(user.getName());
		%>
		<div id = "header">
			<p class = "title">ϰ��ƽ���ƶ����仯��ҵȫ��Э����չ</p>
			<p class = "user">װ�ȵ�С���� 2016-03-12 1289����</p>
		</div>
		<HR align=center color=#ccc SIZE=1>
		<div id = "content">
			<p>�µ�����������µ�����������µ�����������µ�����������µ�����������µ�����������µ����������</p>
			<img src="1.jpg">
			<p>�µ�����������µ�����������µ�����������µ�����������µ�����������µ�����������µ����������</p>
			<img src="2.jpg">
			<p>�µ�����������µ�����������µ�����������µ�����������µ�����������µ�����������µ����������</p>
			<img src="3.jpg">
			<p>�µ�����������µ�����������µ�����������µ�����������µ�����������µ�����������µ����������</p>
			<img src="4.jpg">
		</div>
	</body>
</html>
