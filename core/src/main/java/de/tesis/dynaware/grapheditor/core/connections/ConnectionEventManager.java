package de.tesis.dynaware.grapheditor.core.connections;

import org.eclipse.emf.common.command.CompoundCommand;

import de.tesis.dynaware.grapheditor.CommandAppender;
import de.tesis.dynaware.grapheditor.model.GConnection;

/**
 * Stores any connection created / removed handlers that are set.
 */
public class ConnectionEventManager {

    private CommandAppender<GConnection> connectionCreatedHandler;
    private CommandAppender<GConnection> connectionRemovedHandler;

    /**
     * Sets the handler to be called when connections are created.
     * 
     * @param connectionCreatedHandler the handler to be called when connections are created
     */
    public void setOnConnectionCreated(final CommandAppender<GConnection> connectionCreatedHandler) {
        this.connectionCreatedHandler = connectionCreatedHandler;
    }

    /**
     * Sets the handler to be called when connections are removed.
     * 
     * @param connectionRemovedHandler the handler to be called when connections are removed
     */
    public void setOnConnectionRemoved(final CommandAppender<GConnection> connectionRemovedHandler) {
        this.connectionRemovedHandler = connectionRemovedHandler;
    }

    /**
     * Calls the connection-created handler (if it exists) after a connection was created.
     * 
     * @param connection the connection that was created
     * @param command the compound command that created it
     */
    public void notifyConnectionAdded(final GConnection connection, final CompoundCommand command) {

        if (connectionCreatedHandler != null) {
            connectionCreatedHandler.append(connection, command);
        }
    }

    /**
     * Calls the connection-removed handler (if it exists) after a connection was removed.
     * 
     * @param connection the connection that was removed
     * @param command the compound command that removed it
     */
    public void notifyConnectionRemoved(final GConnection connection, final CompoundCommand command) {

        if (connectionRemovedHandler != null) {
            connectionRemovedHandler.append(connection, command);
        }
    }
}
