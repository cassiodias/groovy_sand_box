/**
* http://docs.groovy-lang.org/latest/html/api/groovy/util/Expando.html
* Represents a dynamically expandable bean.
*/

// adding dynamic attribute 
def expendableBean = new Expando(nome: 'cassio dias')
assert 'cassio dias' == expendableBean.nome

// adding an extra attribute
expendableBean.email = 'cassio@host.com'
assert 'cassio@host.com' == expendableBean.email

// adding method via closure with parameters
expendableBean.newMethodWithParam = { param ->
    "${nome} - ${email} - new param = ${param} \n"
}

// adding method via closure without parameters
expendableBean.newMethodWithoutParam = { 
    "${nome} - ${email} - no param! \n"
}

print expendableBean.newMethodWithoutParam() 
print expendableBean.newMethodWithParam("batata frita")