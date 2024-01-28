import React, {useEffect, useState} from 'react'
import { employeeList } from './../services/EmployeeService';

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])
    useEffect(() => {
        employeeList().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

  return (
    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>
        <hr></hr>
        <table className='table table-striped table-border'>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(emp =>
                        <tr key={emp.empId}>
                            <td>{emp.empId}</td>
                            <td>{emp.firstName}</td>
                            <td>{emp.lastName}</td>
                            <td>{emp.email}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent