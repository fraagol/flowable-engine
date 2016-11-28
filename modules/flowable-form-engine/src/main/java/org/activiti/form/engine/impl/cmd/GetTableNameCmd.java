package org.activiti.form.engine.impl.cmd;

import java.io.Serializable;

import org.activiti.engine.common.api.ActivitiIllegalArgumentException;
import org.activiti.form.engine.impl.interceptor.Command;
import org.activiti.form.engine.impl.interceptor.CommandContext;

public class GetTableNameCmd implements Command<String>, Serializable {

  private static final long serialVersionUID = 1L;

  private Class<?> entityClass;

  public GetTableNameCmd(Class<?> entityClass) {
    this.entityClass = entityClass;
  }

  public String execute(CommandContext commandContext) {
    if (entityClass == null) {
      throw new ActivitiIllegalArgumentException("entityClass is null");
    }
    return commandContext.getTableDataManager().getTableName(entityClass, true);
  }

}