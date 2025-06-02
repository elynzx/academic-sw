
package dao;

import configuration.UsuarioConectado;


public interface IUsuarioDao {

    UsuarioConectado validarLogin(String username, String password);

}
