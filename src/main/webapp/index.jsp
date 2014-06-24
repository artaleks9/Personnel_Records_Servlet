<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Company_PR</title>
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    <body>
        <h1 class="message_1"><%="Personnel Records"%></h1>

        <jsp:useBean id="employees" scope="request" class="java.util.ArrayList"/>
        <div id="wrapper">

            <div id="content">
                 <div id="leftItem" style=" width: 500px; float:left;">

                     <h3>Show employees</h3>

                     <form action="showemployees" method="GET">
                          <input type="submit" value="Get randomize list">
                     </form>

                         <h3>Sort employees</h3>

                         <form action="sortemployees" method="POST">
                             <input type="submit" value="Get list sorted by">
                             <tr>
                                 <td>
                                     <label>
                                         <select name="sort">
                                             <option value="idn">IDN</option>
                                             <option value="name">Surname</option>
                                             <option value="date">Date</option>
                                             <option value="salary">Avr Salary</option>
                                         </select>
                                     </label>
                                 </td>
                             </tr>
                         </form>

                          <div style="margin: 10px;">
                              <form method="GET" action="generateemployees">
                                  Generate employees

                                     <input name="count" type="text" placeholder="enter from 1 to 15"/>
                                         <button type="submit">Generate</button>
                              </form>
                                 <c:out value="Quantity of employees = ${count}"/>
                          </div>

                          <div style="width:300px; margin: 0 auto;">
                               <form method="POST" action="addemployee">
                                    <table>
                                         <tr>
                                             <td colspan="2" style="text-align: center">
                                                 Add employee
                                             </td>
                                         </tr>
                                         <tr>
                                             <td>IDN</td>
                                             <td><label>
                                                 <input name="idn" type="text"/>
                                             </label></td>
                                         </tr>
                                         <tr>
                                             <td>Surname</td>
                                             <td><label>
                                                 <input name="surname" type="text"/>
                                             </label></td>
                                         </tr>
                                         <tr>
                                             <td>Date</td>
                                             <td><input name="date" type="text" placeholder="YYYY/MM/DD"/></td>
                                         </tr>
                                         <tr>
                                             <td>
                                                 <label>
                                                     <select name="type">
                                                         <option value="fixed">Fixed salary(from 500 to 10'000)</option>
                                                         <option value="hourly">Hourly wages(from 5.0 to 100.0)</option>
                                                     </select>
                                                 </label>
                                             </td>
                                             <td>
                                                 <label>
                                                     <input name="salary" type="text"/>
                                                 </label>
                                             </td>
                                         </tr>
                                         <tr>
                                             <td colspan="2" style="text-align: center">
                                                  <button type="submit">Add</button>
                                             </td>
                                         </tr>
                                    </table>
                                   <span style="color: red; "> <c:out value="${errorMsg}"/> </span>
                               </form>
                          </div>
                 </div>

                        <div id="wrapperTable">
                             <table border="1" id="tableEmployees">
                                    <tr>
                                        <th>IDN</th>
                                        <th>Surname</th>
                                        <th>Date</th>
                                        <th>Average salary</th>
                                        <th>DEL</th>
                                    </tr>
                                    <c:forEach var="employee" items="${employees}">
                                        <tr>
                                            <td>${employee.getEmployeeNumber()}</td>
                                            <td>${employee.getSurname()}</td>
                                            <td>${employee.getDateOfBirth()}</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="2"
                                                                  value="${employee.getAvrSalary()}"/></td>
                                            <td>
                                                <a href="deleteemployee?employeename=${employee.getSurname()}">X</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                             </table>
                        </div>
            </div>
        </div>
    </body>
</html>