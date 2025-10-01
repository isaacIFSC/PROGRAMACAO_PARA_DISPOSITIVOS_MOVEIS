# 1)Explique detalhadamente como o 
# gerenciamento de ciclo de vida de uma Activity impacta a performance e o 
# gerenciamento de memória em um aplicativo Android, especialmente em cenários de múltiplas Activitys e rotacionamento de tela. 
# Como os métodos onSaveInstanceState() e onRestoreInstanceState() podem ser usados para garantir que dados cruciais 
# não sejam perdidos, e como isso se relaciona com o conceito de "State Restoration" em sistemas móveis?

R: Caso você não controle corretamente o ciclo de vida das activitys, você irá acabar utilizando muito mais processamento 
que o necessario e ainda pode ocorrer de perder os dados da "sessão", por exemplo: você tem uma activity 
de cadastro e uma de calculo de salario, você utiliza da activity de cadastro e não precisa mais dela mas acaba não respeitando o ciclo de vida 
não utilizou onPause(), nem onStop(), e continuou ali usando o processamento e gastando memoria.
em relação ao gerenciamento e de suma importancia pois por no rotacionamento de tela todos dados são perdidos, 
logo você precisa fazer uso do metodos:onSaveInstanceState() onRestoreInstanceState(); 
para recuperar os dados da "sessão" caso não faça os dados serão perdidos
 

# 2)Explique os principais artefatos disponíveis em um projeto Android como manifesto, res , R, Activitys 
manifest: o manifest é um arquivo xml que contem todas as configurações e permissões do aplicativo android
res: seria a pasta resources do projeto onde fica toda parte grafica, das imagens, layouts, strings e cores
Classe R é a forma de acessar a pasta Resources mas com o java ela contem todos layouts e drawable exemplo: setContentView(R.layout.activity_main);
Activitys: Activity essencialmente é uma tela que o usuario ve no celular, é um ponto de entrada para a interação do usuario e a interface grafica
