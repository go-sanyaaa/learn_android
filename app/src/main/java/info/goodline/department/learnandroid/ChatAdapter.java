package info.goodline.department.learnandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatVH> {

    private LayoutInflater inflater;
    private List<ChatItem> chats;

    public ChatAdapter(Context context, List<ChatItem> chats) {
        this.chats = chats;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ChatVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_view_chat, viewGroup, false);
        return new ChatVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatVH chatVH, int position) {
        ChatItem chatItem = chats.get(position);
        chatVH.ivAvatar.setImageResource(chatItem.getAvatar());
        chatVH.tvChatTheme.setText(chatItem.getTitle());
        chatVH.tvUserName.setText(chatItem.getLastUserName());
        chatVH.tvMessage.setText(chatItem.getLastMessage());
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }
}
