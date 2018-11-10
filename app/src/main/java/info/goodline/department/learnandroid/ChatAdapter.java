package info.goodline.department.learnandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatVH> {

    public interface onItemClickListener {
        void onItemClick(ChatItem item);
    }

    private onItemClickListener clickListener;
    private LayoutInflater inflater;
    private List<ChatItem> chats;



    public ChatAdapter(Context context, List<ChatItem> chats, onItemClickListener clickListener) {
        this.inflater = LayoutInflater.from(context);
        this.chats = chats;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ChatVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_view_chat, viewGroup, false);
        return new ChatVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatVH chatVH, int position) {
        final ChatItem chatItem = chats.get(position);
        chatVH.ivAvatar.setImageResource(chatItem.getAvatar());
        chatVH.tvChatTheme.setText(chatItem.getTitle());
        chatVH.tvUserName.setText(chatItem.getLastUserName());
        chatVH.tvMessage.setText(chatItem.getLastMessage());
        chatVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(chatItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    /**
     * Метод добавления чата в список
     * @param item - чат
     */
    public void insertItem(ChatItem item) {
        // Добавить экземпляр класса ChatItem в коллекцию объектов сразу после первого элемента.
        chats.add(1, item);
        // Обновить адаптер. Вызывав этот метод, в списке recyclerView будет отрисовано добавление
        // нового элемента
        notifyItemInserted(1);
    }
}
