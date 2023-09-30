package DAO;

import Model.Animal;
import Model.Commands;

public class CommandsDAO  {
    private Long id;
    private String commandName;
    public CommandsDAO(){}

    public CommandsDAO (Long id, String commandName){
        this.id = id;
        this.commandName = commandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }
}
