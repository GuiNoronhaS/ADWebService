package br.unisul.ad23automacaowebservice.webservice;

import br.unisul.ad23automacaowebservice.dao.Conexao;
import br.unisul.ad23automacaowebservice.dao.IndividuoDAO;
import br.unisul.ad23automacaowebservice.model.Individuo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Guilherme Noronha
 */
@Path("generic")
@RequestScoped
public class AplicativoWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AplicativoWebService
     */
    public AplicativoWebService() {
    }

    /**
     * Retrieves representation of an instance of
     * br.unisul.ad23automacaowebservice.webservice.AplicativoWebService
     *
     * @param cpf
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Individuo/get/{cpf}")
    public String getIndividuo(@PathParam("cpf") int cpf) {

        Conexao bd = new Conexao();
        bd.conectarBanco();
        IndividuoDAO dao = new IndividuoDAO();
        dao.setCon(bd.getConnection());

        Individuo pessoa = dao.consultarID(cpf);

        bd.desconectarBanco();
        Gson g = new Gson();
        return g.toJson(pessoa);
    }

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listaDoadores/get")
    public String getlistaDoadores() {

        Conexao bd = new Conexao();
        bd.conectarBanco();
        IndividuoDAO dao = new IndividuoDAO();
        dao.setCon(bd.getConnection());

        ArrayList<Individuo> lista = dao.listarVulneraveis();

        bd.desconectarBanco();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listaVulneraveis/get")
    public String getlistaVulneraveis() {

        Conexao bd = new Conexao();
        bd.conectarBanco();
        IndividuoDAO dao = new IndividuoDAO();
        dao.setCon(bd.getConnection());

        ArrayList<Individuo> lista = dao.listarVulneraveis();

        bd.desconectarBanco();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of AplicativoWebService
     *
     * @param content representation for the resource
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //@Path("/cadastrar")
    public void cadastrarIndividuo(String content) {

//        Gson g = new Gson();
//        //Type individuoType = new TypeToken<Individuo>() {}.getType();
//        //Individuo  cadastrar = g.fromJson(content, individuoType);
//        Individuo cadastrar = (Individuo) g.fromJson(content, Individuo.class);
//        Conexao bd = new Conexao();
//        bd.conectarBanco();
//        IndividuoDAO dao = new IndividuoDAO();
//        dao.setCon(bd.getConnection());
//        
//        boolean funcionou = dao.inserir(cadastrar);
//        
//        bd.desconectarBanco();
//        
//        return funcionou;

    }
}
